import Ember from 'ember';

export default Ember.Route.extend({
    accountService: Ember.inject.service('account-service'),
    notifications: Ember.inject.service('notification-messages'),
    actions:{
    register(){
            this.get('accountService').
            userRegister(this.controller.get("firstName"),
                        this.controller.get("lastName"),
                        this.controller.get("email"),
                        this.controller.get("phone"),
                        this.controller.get("country"),
                        this.controller.get("city"),
                        this.controller.get("password"))
                        .done(response => {
                             this.get('notifications').success('Successful registration!', {
                              autoClear: true,
                              clearDuration: 1500
                            });
                             this.transitionTo('home');
                       })
                         .fail(response => {
                            this.get('notifications').error('Account already exists', {
                             autoClear: true,
                             clearDuration: 1500
                           });
                         });
                       }

        }
})
