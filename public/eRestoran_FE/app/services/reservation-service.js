import Ember from 'ember';

export default Ember.Service.extend({
  createReservation(tables,account_id,restaurant_id) {
  return $.ajax({
      method:'POST',
      url:'/api/v1/reservation',
      data: JSON.stringify({
          tables,
          account_id,
          restaurant_id
      }),
      contentType:"application/json"
  })
  }
});
