class MathDojo:
    def __init__(self):
        self.result = 0
    def add(self, num, *nums):
        self.result += num + sum(nums)
        return self
    
    def subtract(self, num, *nums):
        self.result -= num + sum(nums)
        return self

md = MathDojo()
x = md.add(2).add(2,5,1).subtract(3,2).result
print(x)	

x1 = MathDojo()
x = x1.add(-1,3,2).add(0).add(3,3).result
print(x)	

x = x1.subtract(3,2).subtract(1).subtract(8).result
print(x)	