//@version 0.7, 2008-02-13, Sang-Moon Oh

/**
* This script contains codes to extend built-in classes
*/

/**
 *
 * @version 0.7
 */
Object.prototype.implements=function(functionName){
	return this && this[functionName] && this[functionName] instanceof Function
}

/**
 *
 * @since 0.7
 */
Array.prototype.indexOf=function(obj){
	var result = -1;
	for(var i=0; i < this.length; i++){
		if(this[i] == obj){
			result = i;
			break;
		}
	}
	
	return result;
}

/**
 *
 * @since 0.7
 */
Array.prototype.contains=function(obj){
	return (this.indexOf(obj) >= 0)
}



