import Ember from 'ember';

export default Ember.Service.extend({
  leaveComment(content,mark,account,restaurant) {
  return $.ajax({
      method:'POST',
      url:'/api/v1/comment',
      data: JSON.stringify({
          content,
          mark,
          account,
          restaurant
      }),
      contentType:"application/json"
  })
}
});
