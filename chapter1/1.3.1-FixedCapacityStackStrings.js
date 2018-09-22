class FixedCapacityStackStrings {
    constructor(n) {
        this.total = n;
        this.s = [];
        this.capcity = 0;
        this.count = 0;
    }

    push(ch) {
        if(this.count === this.total) {
            throw new Error('out of index');
        }
        this.count++;
        this.s.push(ch);
    }

    pop() {
        if(this.count > 0) {
            this.count--;
            return this.s.pop();
        }else {
            return undefined;
        }
    }

    size() {
        return this.count;
    }
    isEmpty() {
        return this.count > 0;
    }
}

let fixedCapacityStackStrings = new FixedCapacityStackStrings(3);
fixedCapacityStackStrings.push(2);
console.log(fixedCapacityStackStrings.pop())
fixedCapacityStackStrings.push(1);
fixedCapacityStackStrings.push(3);

console.log(fixedCapacityStackStrings.size())
// fixedCapacityStackStrings.push(2)