let str = process.argv[2];

if(!str) {
    throw new Error('表达式不存在');
}

let optStack = [];
let valStack = [];

let optreg = /[^\d.]/;
let valreg = /[\d.]/;
let resArr = [];
let st = '';
for (let i = 0; i < str.length-1; i++) {
    if (valreg.test(str[i])) {
        if (optreg.test(str[i+1])) {
            st = st + str[i];
            resArr.push(Number.parseFloat(st));
            st = '';
        } else {
            st += str[i];
        }
    }else {
        resArr.push(str[i]);
    }
}

if(st) {
    st += str[str.length - 1];
    resArr.push(Number.parseFloat(st));
}else {
    if(valreg.test(str[str.length - 1])) {
        resArr.push(Number.parseFloat(str[str.length - 1]));   
    }else {
        resArr.push(str[str.length - 1]);
    } 
}


console.log(resArr)
let len = resArr.length;
for(var i = 0; i < len; i++) {
    let tt = resArr[i];
    let optReg = /[\+\-\*\/]+/
    if(optReg.test(tt)) {
        optStack.push(tt);
    }else if(tt === ')') {
        let oo = optStack.pop();
        let v = valStack.pop();
        switch (oo) {
            case '+': 
                v = v + valStack.pop();
                break;
            case '-': 
                v = valStack.pop() - v;
                break;
            case '*': 
                v = v * valStack.pop();
                break;
            case '/': 
                v = valStack.pop() / v;
                break;    
        }
        valStack.push(v); 
        

    }else if(tt === '(') {
        
    }else {
        valStack.push(tt);
    }
}

console.log(valStack.pop());


