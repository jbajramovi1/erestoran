import Ember from 'ember';
import $ from 'jquery';

export default Ember.Service.extend({
    api: Ember.inject.service(),

    userLogin(email,password) {
    return $.ajax({
        
        method:'POST',
        url:'/api/v1/login',
        data: JSON.stringify({
            email,
            password
        }),
        contentType:"application/json"
    });},
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