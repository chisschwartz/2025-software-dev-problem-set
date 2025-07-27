// Brute Force //


var MinStack = function() {
    this.stack=[];
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    this.stack.push(val);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    this.stack.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.stack[this.stack.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    
    const tmp = [];
    let mini = this.stack[this.stack.length - 1];

    while (this.stack.length > 0) {
        mini = Math.min(mini, this.stack[this.stack.length - 1]);
        tmp.push(this.stack.pop());
    }

    while (tmp.length > 0) {
        this.stack.push(tmp.pop());
    }

    return mini;
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

// Two Stacks //


var MinStack = function() {
    this.stack=[];
    this.minStack = [];
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    this.stack.push(val);

    val = Math.min(
        val,
        this.minStack.length === 0 ? val : this.minStack[this.minStack.length - 1],
    );
    
    this.minStack.push(val)
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    this.stack.pop();
    this.minStack.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.stack[this.stack.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.minStack[this.minStack.length - 1];
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

// One Stack //


var MinStack = function() {
    this.stack=[];
    this.min = Infinity;
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {

    if (this.stack.length === 0) {
        this.stack.push(0);
        this.min = val;
    } else {
        this.stack.push(val - this.min);
        if (val < this.min) this.min = val;
    }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {

    if (this.stack.length === 0) return;
    const pop = this.stack.pop();
    if (pop < 0) this.min -= pop; 
    //deletes last item in the stack
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    const top = this.stack[this.stack.length - 1];
    //finds the top most element
    return top > 0 ? top + this.min : this.min;
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.min;
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */