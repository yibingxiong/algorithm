function Fibonacci(n)
{
    // write code here
    let res = [0,1];
    let k = 0;
    while(res.length < n+1) {
        let i = res.length;
        res.push(res[i-1]+res[i-2])
    }
    return res[n]
}

let a = Fibonacci(4);

console.log(a)