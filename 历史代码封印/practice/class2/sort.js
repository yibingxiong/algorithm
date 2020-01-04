const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin
});

var data=[];

rl.on('line',function(line){
    line=line.trim();
    data.push(line);
    if(data.length===3){
        var arr=data[1].split(' ').map((item) => {
            return parseInt(item.trim())
        });
        arr = heapSort(arr);
        if(data[2] == '1') {
            arr.reverse();
        }
        console.log(arr.join(' '));
        //reset
        data=[];
    }
     
})




function heapInsert(arr, index) {
    while(arr[index] > arr[Math.floor((index-1)/2)]) {
        swap(arr, index, Math.floor((index-1)/2));
        index = Math.floor((index-1)/2);
    } 
}

// 将一个数组变成大根堆
function toBigHeap(arr) {
    let size = 0;
    let len = arr.length;
    for(let i =0; i< len;i++) {
        heapInsert(arr, i);
    }
    return arr;
}

function swap(arr, i, j) {
    let tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp; 
}

// 下沉操作
function heapify(arr, index, heapSize) {
    let left = index * 2 +1;
    while(left < heapSize) {
        let largest = (left+1<heapSize && arr[left+1] > arr[left])? left+1: left;

        largest = arr[largest]>arr[index]?largest:index;

        if (largest === index) {
            break;
        }

        swap(arr, index, largest);
        index = largest;
        left = 2*index+1;
    }
}

function heapSort(arr) {
    let heap = toBigHeap(arr);
    let heapSize = heap.length;
    swap(heap, 0, --heapSize);
    while(heapSize> 0) {
        heapify(heap, 0,heapSize);
        swap(heap, 0, --heapSize);
    }
    
    return heap;
}