import Ember from 'ember';

export default Ember.Service.extend({
  currentUser:null,
  currentUserId:null,
  application:Ember.inject.controller('application'),
  authenticate(username,password,id){
    this.set('currentUser',username);
    this.set('currentUserId',id);
  },
  isAuthenticated(){
    if (this.get('currentUser')==null) return false;
    return true;
  },
  getCurrentUser(){
    return this.get('currentUser');
  },
  getCurrentUserId(){
    return this.get('currentUserId');
  },
  unauthenticate(){
    this.set('currentUser',null);
    this.set('currentUserId',null);
  }

});
