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


function main() {
    let arr = [
        {
            name: '1',
            score: 5,
        },
        {
            name: '2',
            score: 3
        },
        {
            name: '2',
            score: 1
        },
        {
            name: '3',
            score: 3
        },
        {
            name: '4',
            score: 3
        }
    ];

    sort(arr, 0, arr.length - 1);

    console.log(arr);
}

main();