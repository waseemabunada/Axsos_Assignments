function pizzaOven(crustType, sauceType, cheeses, toppings) {
    return {
        crustType: crustType,
        sauceType: sauceType,
        cheeses: cheeses,
        toppings: toppings
    };
}

var pizza1 = pizzaOven("deep dish", "traditional", ["mozzarella"], ["pepperoni", "sausage"]);

var pizza2 = pizzaOven("hand tossed", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]);

var pizza3 = pizzaOven("thin crust", "alfredo", ["parmesan", "mozzarella"], ["chicken", "spinach", "garlic"]);

var pizza4 = pizzaOven("stuffed crust", "bbq", ["cheddar", "mozzarella"], ["bacon", "onions", "jalapeños"]);

console.log(pizza1);
console.log(pizza2);
console.log(pizza3);
console.log(pizza4);
