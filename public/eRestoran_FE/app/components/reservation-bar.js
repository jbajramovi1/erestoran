import Ember from 'ember';

export default Ember.Component.extend({
  reservation: Ember.inject.service('restaurant-service'),
  people:2,
  time:"6 PM",
  actions:{
    selectPeople(value){
      this.set('people',value);
    },

    selectTime(value){
      this.set('time',value);
    }
  }
});
