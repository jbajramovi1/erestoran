import Ember from 'ember';

export default Ember.Service.extend({
  leaveComment(content,mark,insertTime,account,restaurant) {
  return $.ajax({
      method:'POST',
      url:'/api/v1/comment',
      data: JSON.stringify({
          content,
          mark,
          insertTime,
          account,
          restaurant
      }),
      contentType:"application/json"
  })
}
});
