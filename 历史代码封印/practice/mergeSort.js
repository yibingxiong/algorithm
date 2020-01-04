function mergeSort(arr, l, r) {
    let middle = l + Math.floor((r - l) / 2);
    if(r === l) {
        return;
    }
    mergeSort(arr, l, middle);
    mergeSort(arr, middle+1, r);
    merge(arr, l, r, middle);
}

function merge(arr, l,r,mid) {
    let len = arr.length;
    let i = l;
    let j = mid+1;
    let help = [];
    while(j <= r && i <=mid) {
        if (arr[i] <= arr[j]) {
            help.push(arr[i++]);
        } else {
            help.push(arr[j++]);
        }
    }
    while(i <=mid) {
        help.push(arr[i++]);
    }
    while(j<=r) {
        help.push(arr[j++]);
    }

    for(let i = 0; i< help.length; i++) {
        arr[i+l] = help[i];
    }
}

let arr = [10,2,3,4];

mergeSort(arr, 0, arr.length-1);

console.log(arr);