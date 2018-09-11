/**
 * 求两个数的最大公约数 欧几里得算法 
 */

 function gcd(p, q) {
    if(q === 0) {
        return p;
    }

    let r = p % q;
    return gcd(q, r);
 }

// 测试
 console.log(gcd(0,1));
 console.log(gcd(1,0));
 console.log(gcd(6,3));