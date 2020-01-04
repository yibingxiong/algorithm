const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin
});

var data=[];

rl.on('line',function(line){
    let arr = line.split('');
    arr.sort((item1, item2) => {
        let alReg = /[A-Z][a-z]/;
        if(!alReg.test(item1) || !alReg.test(item2)) {
            return 0;
        }

        return item1 > item12;
    })
    
    console.log(arr.join(' '));
})