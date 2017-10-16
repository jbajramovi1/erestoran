import Ember from 'ember';

export default Ember.Controller.extend({
  account: Ember.inject.service('account-service'),

  actions:{
    login(username,password){
      this.get('account').userLogin(username,password);
    }
  }
});
