/**
 * 二分查找, 非递归实现
 */

 function binarySearch(key, arr) {
     let low = 0;
     let high = arr.length - 1;

     while(low <= high) {
         let mid = Math.floor(low + (high - low)/2);
         let item = arr[mid];
         if(key === item) {
             return mid;
         }else if(key < item) {
             high = mid -1;
         } else {
             low = mid + 1;
         }
     }
     return -1;
     
 }

 console.log(binarySearch(1, [1,2,3,4,5,6]));
 console.log(binarySearch(6, [1,2,3,4,5,6]));
 console.log(binarySearch(4, [1,2,3,4,5,6]));
