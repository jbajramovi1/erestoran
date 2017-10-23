import Ember from 'ember';
import Account from '../models/account';
import Restaurant from '../models/restaurant';
export default Ember.Component.extend({
  reservation: Ember.inject.service('reservation-service'),
  notifications: Ember.inject.service('notification-messages'),
  sessionService: Ember.inject.service('session-service'),
  people:2,
  time:"6 PM",
  date:new Date(),
  actions:{
    selectPeople(value){
      this.set('people',value);
    },

    selectTime(value){
      this.set('time',value);
    },
    selectDate(input){
      this.set('date',input);
    },
    saveReservation(){
      var account=Account.create({});
      var restaurant=Restaurant.create({});
      account.set('id',this.get('sessionService').getCurrentUserId());
      restaurant.set('id',this.get('model.id'))
      this.get('reservation').createReservation(this.get('people'),this.get('date'),account,restaurant)
      .done(response => {
           this.get('notifications').success('Successful reservation!', {
            autoClear: true,
            clearDuration: 1500
          });
           this.transitionTo('home');
     })
       .fail(response => {
          this.get('notifications').error('Reservation error', {
           autoClear: true,
           clearDuration: 1500
         });
       });
     }
    }

});
