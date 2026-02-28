import os

src_path = "src/application"
out_path = "output.txt"
class_lsts = []


def getPackage(line:str) -> str:
    return line.strip()

def getClass(line: str) -> str:
    if("abstract" in line):
        split = line.split(" ")
        print(split[3])
        return split[3].strip()
    
    split = line.split(" ")
    return split[2].strip()


def getFields(line: str) -> str:
    line = line.strip().replace(";","")
    split = line.split(" ")

    if split[1].endswith(",") and len(split) > 3:
        split[1] = split[1] + split[2]
        split.remove(split[2])

    operator:str = getVisibilityOperator(split[0])
    name = split[2]
    data_type = split[1]

    return f"{operator} {name}: {data_type}"



def getMethods(line: str) -> str:
    line = line.strip().rstrip("{").strip()
    split = line.split(" ")

    index:int = 1
    hasModifier:bool = False
    modifier:str = ""
    if split[1] in ["static", "final", "abstract"]:
        hasModifier = True
        modifier = split[1]
        index = 2
    elif( "(" in split[1]):
        # constructor
        index:int = 0

    operator:str = getVisibilityOperator(split[0])
    return_type = ""

    if(not index == 0):
        return_type = split[index]

    name_with_params = " ".join(split[index + 1:])
    name = name_with_params[:name_with_params.find("(")]
    param_part = name_with_params[name_with_params.find("(")+1 : name_with_params.find(")")]

    print(param_part)

    param_lst:list = []

    if param_part != "":
        params = param_part.split(",")

        for param in params:
            param = param.strip()
            param_split = param.split(" ")
            print(param_split)
            param_lst.append(f"{param_split[1]}: {param_split[0]}")

    param_string = ", ".join(param_lst)


    if(hasModifier):
        return f"{operator} {name}({param_string}): {return_type} " + "{" + modifier + "}"


    return f"{operator} {name}({param_string}): {return_type}"


def getVisibilityOperator(text:str) -> str:
    match text:
        case "private":
            return "-"
        case "public":
            return "+"
        case "protected":
            return "#"
    return ""

def read_file(element) -> list:
    class_lst:list = []
    with open(element.path, "r") as input_file:
        print(element.name)

        for line in input_file:
            if "package" in line:
                class_lst.append(getPackage(line))
            if "public" in line and ("class" in line or "interface" in line):
                class_lst.append(getClass(line))
            if ("public" in line or "private" in line or "protected" in line) and ";" in line:
                if(("(" in line and "=" in line) or not ("(" in line or "=" in line)):
                    class_lst.append(getFields(line))
            if ("public" in line or "private" in line or "protected" in line) and (not "class" in line or not "interface" in line):
                if("(" in line and not "=" in line):
                    class_lst.append(getMethods(line))
                    print(line)

    class_lst.append("\n")
    return class_lst

# source: https://www.geeksforgeeks.org/python/python-loop-through-folders-and-files-in-directory/
def scan_dir(src_path):
    for element in os.scandir(src_path):
        if element.is_file():
            class_lsts.extend(read_file(element))

        elif element.is_dir():
            scan_dir(element.path)


if __name__ == "__main__":
    scan_dir(src_path)
    with open(out_path, "w") as out_file:
        out_file.write('\n'.join(class_lsts))