import Ember from 'ember';

export default Ember.Route.extend({
    accountService: Ember.inject.service('account-service'),
    notifications: Ember.inject.service('notification-messages'),
    setupController: function(controller, model) {
      this._super(controller, model);
      this.controller.set('errorEmail',null);
      this.controller.set('errorPassword',null);
      this.controller.set('errorConfirmPassword',null);
      this.controller.set('firstName',null);
      this.controller.set('lastName',null);
      this.controller.set('email',null);
      this.controller.set('password',null);
      this.controller.set('phone',null);
      this.controller.set('country',null);
      this.controller.set('city',null);
      this.controller.set('passwordConf',null);
  },
    actions:{
    register(){
            this.controller.set('errorEmail',null);
            this.controller.set('errorPassword',null);
            this.controller.set('errorConfirmPassword',null);
            let emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            let errorFront=false;
            if (!this.controller.get('password')) {
              this.controller.set("errorPassword","Password field is required");
              errorFront=true;
            }
            else if (this.controller.get('password')!=this.controller.get('passwordConf')) {
              this.controller.set("errorConfirmPassword","Password doesn't match");
              errorFront=true;
            }
            if (!this.controller.get('email')) {
              this.controller.set("errorEmail","Email field is required");
              errorFront=true;
            }
            else if (!emailRegex.test(this.controller.get('email'))){
              this.controller.set("errorEmail","Email format is incorrect");
              errorFront=true;
            }

            if (errorFront){
              this.get('notifications').error("Authentication error occured!", {
               autoClear: true,
               clearDuration: 1500
                });
              return;
            }
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
                           var data = $.parseJSON(response.responseText);

                              this.controller.set('errorEmail',data.email);
                              this.controller.set('errorPassword',data.password);

                              this.get('notifications').error("Authentication error occured!", {
                               autoClear: true,
                               clearDuration: 1500
                             });
                         });
                       }

        }
})
