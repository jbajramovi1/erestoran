import Ember from 'ember';

export default Ember.Service.extend({
  leaveComment(content,mark) {
  return $.ajax({
      method:'POST',
      url:'/api/v1/comment',
      data: JSON.stringify({
          content,
          mark
      }),
      contentType:"application/json"
  })
}
});
