package com.iocor.stats;

public class CachedValue<type> {
	private boolean updateNeeded;
	private type value;
	public CachedValue(type value){
		this.value = value;
		this.updateNeeded = false;
	}
	public type GetValue(){
		if (this.updateNeeded){
			throw new IllegalStateException("cannot get value when update needed");
		} else{
			return this.value;
		}
	}
	public boolean GetUpdateNeeded(){
		return this.updateNeeded;
	}
	public void SetValue(type value){
		this.value = value;
		this.updateNeeded = false;
	}
	public void SetOutDated(){
		this.updateNeeded = true;
	}
}
