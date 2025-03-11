let currentInput = '0';  
let previousInput = null; 
let operator = null;      

const display = document.getElementById('display'); 


function updateDisplay() {
    display.textContent = currentInput;
}


function press(value) {
    if (currentInput === '0' || currentInput === 'error') {
        currentInput = value; 
    } else {
        currentInput += value; 
    }
    updateDisplay();
}


function setOP(op) {
    if (previousInput !== null && operator !== null) {
        calculate(); 
    }
    previousInput = currentInput;
    operator = op;               
    currentInput = '0';          
}

function calculate() {
    if (previousInput === null || operator === null) return; 

    let result = 0;
    let prev = parseFloat(previousInput);
    let current = parseFloat(currentInput);

   
    switch (operator) {
        case '+': result = prev + current; break;
        case '-': result = prev - current; break;
        case '*': result = prev * current; break;
        case '/': 
            if (current === 0) {
                result = 'error';
            } else {
                result = prev / current;
            }
            break;
    }

    currentInput = result.toString(); 
    previousInput = null; 
    operator = null;
    updateDisplay();
}


function clr() {
    currentInput = '0';
    previousInput = null;
    operator = null;
    updateDisplay();
}


document.querySelectorAll('.btn').forEach(button => {
    button.addEventListener('click', () => {
        let value = button.getAttribute('data-value');
        if (value === 'C') {
            clr();
        } else {
            press(value);
        }
    });
});

document.querySelectorAll('.operator').forEach(button => {
    button.addEventListener('click', () => {
        let op = button.getAttribute('data-value');
        setOP(op);
    });
});

document.getElementById('equals').addEventListener('click', calculate);


updateDisplay();
