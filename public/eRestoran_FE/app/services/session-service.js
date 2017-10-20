import Ember from 'ember';

export default Ember.Service.extend({
  currentUser:null,
  application:Ember.inject.controller('application'),
  authenticate(username,password){
    this.set('currentUser',username);
  },
  getCurrentUser(){
    return this.get('currentUser');
  },
  unauthenticate(){
    this.set('currentUser',null);
  }

});
