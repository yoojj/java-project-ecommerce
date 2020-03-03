export const cookie = {
		
	set(key, value, days=1) {
		
	    let date = new Date();
	    
	    date.setTime(date.getTime() + 24*60*60*1000*days);
	    
	    document.cookie = `${key}=${value};expires=${date.toGMTString()}`;
	    
	},
	
	get(key) {
		
	    const value = document.cookie.match(`(^|;)?${key}=([^;]*)(;|$)`);
	    
	    return value ? value[2] : null;
	},
	
	del(key) {
	    this.set(key, '', -1);
	},
		
};