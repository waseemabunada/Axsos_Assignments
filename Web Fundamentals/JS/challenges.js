
//1-Always Hungry
function alwaysHungry(arr) {
    var foundFood = 0;
    var qwe=[]
    for (var i = 0; i < arr.length; i++) {  
        if (arr[i] === "food") {  
            qwe.push("yummy");
            foundFood = 1;
        }
    }
    if (!foundFood) {
       return  "I'm hungry";
    }
    return qwe;
}

console.log(alwaysHungry([3.14, "food", "pie", true, "food"]));
console.log (alwaysHungry([4, 1, 5, 7, 2]));




//2- High Pass Filter
function highPass(arr, cutoff) {
    var filteredArr = arr.filter(function(value) {
        return value > cutoff; 
    });
    return filteredArr;
}
var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
console.log(result); 




//3=Better than average 

function betterThanAverage(arr) {
    var sum = 0;
    var count = 0;
    for (var i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    var average = sum / arr.length;
  
 
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] > average) {
            count++;
        }
    }
    return count;
}
var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
console.log(result);

//4-Array Reverse 
function reverse(arr) {
    var reversedArray = [];
    for (var i = arr.length - 1; i >= 0; i--) {
        reversedArray.push(arr[i]);
    }
    return reversedArray;
}
var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result)

//5-Fibonacci Array
function fibonacciArray(n) {

    var fibArr = [0, 1];
    var count = 2;
    while (count != n) {
        fibArr[count] = fibArr[count-1] + fibArr[count-2];
        count++;
    }
    return fibArr;
}  
var result = fibonacciArray(10);
console.log(result);