const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin
});

let lineCount = -1;
let type = 0;
let nowLine = 1;
let data = [];
rl.on('line', (input) => {
    if (lineCount === data.length) {
        let res = handle(data, type);
        print(res);
        nowLine = 1;
        data=[]
        lineCount = -1;
    }
    if(nowLine === 1) {
        lineCount = Number.parseInt(input, 10);
        nowLine++;
    } else if (nowLine === 2) {
        type = Number.parseInt(input, 10);
        nowLine++;
    } else if (data.length <= lineCount){
        let arr = input.split(' ');
        data.push({
            name: arr[0],
            score: Number.parseInt(arr[1])
        });
        nowLine++;
    }

})



function handle(data, type) {
    if (type === 1) {
        data.sort((item1, item2) => {
            return item1.score - item2.score
        })
    } else {
        data.sort((item1, item2) => {
            return item2.score - item1.score
        }) 
    }
    return data;
}

rl.on('close', () => {
      
    if (data.length === lineCount) {
        print(handle(data, type))
    }
})


function print(res) {
    let k = [];
    for(let i=0;i<res.length;i++){
        k.push(`${res[i].name} ${res[i].score}`);
        
    }
    console.log(k.join('\n'));
}
