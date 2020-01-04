/**
 * 二分查找, 递归实现
 */

 function binarySearch(key, arr, low, high) {
     if(!low) low = 0;
     if(!high) high = arr.length - 1;

     let mid = Math.floor(low + (high - low)/2);

     let item = arr[mid];
     if(item === key) {
         return mid;
     }else if(low <= high) {
         if(key < item) {
             return binarySearch(key, arr, low, mid-1);
         }else {
             return binarySearch(key, arr, mid+1, high);
         }
     }else {
        return -1;
     }  
 }

 console.log(binarySearch(1, [1,2,3,4,5,6]));
 console.log(binarySearch(6, [1,2,3,4,5,6]));
 console.log(binarySearch(4, [1,2,3,4,5,6]));
