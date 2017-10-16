import Ember from 'ember';
import $ from 'jquery';

export default Ember.Service.extend({
    api: Ember.inject.service(),
    session:Ember.inject.service('session-service'),
    userLogin(email,password) {
      var self=this;
      return $.ajax({
          method:'POST',
          url:'/api/v1/login',
          data: JSON.stringify({
              email,
              password
          }),
          contentType:"application/json",
          success:function(){
              self.get('session').authenticate(email,password);
          }
      })
    },
    userRegister(firstName,lastName,email,phone,country,city,password) {
    return $.ajax({
        method:'POST',
        url:'/api/v1/user',
        data: JSON.stringify({
            firstName,
            lastName,
            email,
            phone,
            country,
            city,
            password
        }),
        contentType:"application/json"
    })
  }
});
