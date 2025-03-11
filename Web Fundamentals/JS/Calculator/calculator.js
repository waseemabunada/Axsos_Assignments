var currentInput = '0';
var operator = null;
var previousInput = null;


const buttons = document.querySelectorAll('.btn');
buttons.forEach(button => {
    button.addEventListener('click', function() {
        const value = this.getAttribute('data-value');
        if (value === 'C') {
            clr(); 
        } else {
            press(value);
        }
    });
});

const operators = document.querySelectorAll('.operator');
operators.forEach(operatorButton => {
    operatorButton.addEventListener('click', function() {
        const value = this.getAttribute('data-value');
        setOP(value);
    });
});


document.getElementById('equals').addEventListener('click', calculate);

document.querySelector('[data-value="C"]').addEventListener('click', clr);

function clr() {
    currentInput = '0';
    previousInput = null;
    operator = null;
    updateDisplay();
}

function press(value) {
    if (currentInput === '0' && value !== '.') {
        currentInput = value;
    } else {
        currentInput += value;
    }
    updateDisplay();
}

function setOP(op) {
    if (previousInput === null) {
        previousInput = currentInput;
        currentInput = '0';
    }
    operator = op;
}

function calculate() {
    if (previousInput === null || operator === null) return;
    let result;
    const prev = parseFloat(previousInput);
    const current = parseFloat(currentInput);

    switch (operator) {
        case '+':
            result = prev + current;
            break;
        case '-':
            result = prev - current;
            break;
        case '*':
            result = prev * current;
            break;
        case '/':
            if (current === 0) {
                result = 'Error';
            } else {
                result = prev / current;
            }
            break;
    }

    currentInput = result.toString();
    operator = null;
    previousInput = null;
    updateDisplay();
}

function updateDisplay() {
    document.getElementById('display').textContent = currentInput;
}
