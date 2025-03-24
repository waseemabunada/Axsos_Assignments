#functions1
def biggie_size(lst):
    for i in range(len(lst)):
        if lst[i] > 0:
            lst[i] = 'big'
    return lst 
print(biggie_size([-1, 3, 5, -5]))  

#functions2
def count_positives(lst):
    count = 0
    for i in lst:
        if i > 0:
            count += 1
    lst[-1] = count
    return lst
print(count_positives([1, 6, -4, -2, -7, -2]))
print(count_positives([-1, 1, 1, 1]))

# function3
def sum_total(lst):
    sum = 0
    for i in lst:
        sum += i
    return sum
print (sum_total([1,2,3,4])) 
print (sum_total([6,3,-2])) 

# function4
def average(lst):
    sum = 0
    for i in lst:
        sum += i
    total = sum/len(lst)
    return total 
print (average([1,2,3,4])) 

# function5
def length(lst):
    return len(lst)
print (length([37,2,1,-9])) 

# function6
def minimum(lst):
    if len(lst) == 0:
        return False
    else:
        min = lst[0]
        for i in lst:
            if i < min:
                min = i
        return min
print (minimum([37,2,1,-9]))
print (minimum([]))

# function7
def maximum(lst):
    if len(lst) == 0:
        return False
    else:
        max = lst[0]
        for i in lst:
            if i > max:
                max = i
            return max
print (maximum([37,2,1,-9]))
print (maximum([]))

# function8
def ultimate_analysis(lst):
    return {'sumTotal': sum_total(lst), 'average': average(lst), 'minimum': minimum(lst), 'maximum': maximum(lst), 'length': length(lst)}
print (ultimate_analysis([37,2,1,-9]))

#functions9
def reverse_list(lst):
    left_index = 0
    right_index = len(lst) -1
    for num in range (int(len(lst)/2)):
        lst[left_index], lst[right_index] = lst[right_index], lst[left_index]
        left_index += 1
        right_index -= 1
    return lst
print(reverse_list([3, 1, 4, 1, 5]))




