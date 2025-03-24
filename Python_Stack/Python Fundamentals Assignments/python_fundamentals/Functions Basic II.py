# Function 1:
def countdown (maxNumber):
    numbers = []
    for num in range(maxNumber,-1,-1):
        numbers.append(num)
    return numbers
print(countdown(5))

# Function 2:
def print_and_return(twoNumberList):
    print(twoNumberList[0])
    return twoNumberList[1]
print(print_and_return([1,2]))

# Function 3:
def first_plus_length (listNumbers):
    return listNumbers[0]+len(listNumbers)
print(first_plus_length([1,2,3,4,5]))

# Function 4:
def values_greater_than_second(arr):
    array=[]
    if len(arr) < 2:
        return False
    
    for i in range(len(arr)):
        if (arr[i] > arr[1]):
            array.append(arr[i])


    print(len(array))
    return array
print(values_greater_than_second([5,2,3,2,1,4]))



# Function 5:
def length_and_value(size, value):
    return [value] * size
print(length_and_value(4,7))
print(length_and_value(6,2))

