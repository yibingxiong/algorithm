function sort(arr, l, r) {
    if (l === r) {
        return;
    }

    let mid = Math.floor((l + r)/2);
    sort(arr, l, mid);
    sort(arr, mid + 1, r);
    merge(arr, l, r, mid);
}

function compare(item1, item2) {
    if (item1.score < item2.score) {
        return -1;
    }
    if (item1.score === item2.score) {
        return 0;
    }
    return 1;
}
function merge(arr, l, r, m) {
    let res = [];
    let i = l;
    let j = m + 1;

    while(i <= m && j <= r) {
        compare(arr[i], arr[j]) < 1 ? res.push(arr[i++]) : res.push(arr[j++]);
    }

    while(i <= m) {
        res.push(arr[i++]);
    }

    while(j<=r) {
        res.push(arr[j++]);
    }

    for(let i = 0; i < res.length; i++) {
        arr[l+i] = res[i];
    }
}


var readline = require('readline');

function main() {
  const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
    });
    let lines = 0;
    let data = [];
    let count = 0;
    let type = 0;
    
    rl.on('line', function(line){
        if(lines === 0) {
            count = Number.parseInt(line);
        }
        if(lines === 1) {
            type = line;
        }
        
        if (lines!==0 && lines !== 1) {

            let st = line.split(' ');
            if (data.length < count) {
                   data.push(
                        {name: st[0], score: Number.parseFloat(st[1])}
                    )
            } else {
                if (data.length >1) {
                    sort(data, 0, data.length - 1);
                }
                let res = '';
                if(type == 0) {    // 降序
                    for(let i = data.length -1; i >= 0; i--) {
                        res += `${data[i].name} ${data[i].score}\r\n`;
                    }
                } else {
                    for(let i = 0; i < data.length; i++) {
                        res += `${data[i].name} ${data[i].score}\r\n`;
                    }
                }
                console.log(res);
                lines = 0;
                
                count = Number.parseInt(line);
                data = [];
                
            }
        }
        lines++;
        
    });  
    rl.on('close', function() {
        if (data.length >1) {
            sort(data, 0, data.length - 1);
        }
        let res = '';
        if(type == 0) {    // 降序
            for(let i = data.length -1; i >= 0; i--) {
                res += `${data[i].name} ${data[i].score}\r\n`;
            }
        } else {
            for(let i = 0; i < data.length; i++) {
                res += `${data[i].name} ${data[i].score}\r\n`;
            }
        } 
        console.log(res);
    })
}


main()




