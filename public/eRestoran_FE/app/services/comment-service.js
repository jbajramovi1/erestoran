import Ember from 'ember';

export default Ember.Service.extend({
  leaveComment(content,mark,restaurant_id,account_id) {
  return $.ajax({
      method:'POST',
      url:'/api/v1/comment',
      data: JSON.stringify({
          content,
          mark,
          account_id,
          restaurant_id
      }),
      contentType:"application/json"
  })
}
});
