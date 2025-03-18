
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(username: String)(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.53*/("""

"""),_display_(/*3.2*/main("Home")/*3.14*/ {_display_(Seq[Any](format.raw/*3.16*/("""
"""),format.raw/*4.1*/("""<div class="header">
    <h1>Welcome """),_display_(/*5.18*/username),format.raw/*5.26*/("""</h1>
    <div>
        <a href=""""),_display_(/*7.19*/routes/*7.25*/.HomeController.follows()),format.raw/*7.50*/("""" class="btn">My Network</a>
        <a href=""""),_display_(/*8.19*/routes/*8.25*/.HomeController.logout()),format.raw/*8.49*/("""" class="logout-btn">Logout</a>
    </div>
</div>

<div class="content">
    <div class="create-post">
        <h2>Create New Post</h2>
        <form id="createPostForm"
            style="display: flex; flex-direction: column; gap: 1rem; max-width: 600px; margin: 0 auto; padding: 1.5rem; background: #f5f5f5; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);">
            """),_display_(/*17.14*/helper/*17.20*/.CSRF.formField),format.raw/*17.35*/("""
            """),format.raw/*18.13*/("""<div style="display: flex; flex-direction: column; gap: 0.5rem;">
                <label for="title" style="font-weight: 600; color: #333;">Title:</label>
                <input type="text" id="title" name="title" required
                    style="padding: 0.75rem; border: 1px solid #ddd; border-radius: 4px; font-size: 1rem;">
            </div>
            <div style="display: flex; flex-direction: column; gap: 0.5rem;">
                <label for="body" style="font-weight: 600; color: #333;">Content:</label>
                <textarea id="body" name="body" required
                    style="padding: 0.75rem; border: 1px solid #ddd; border-radius: 4px; min-height: 120px; font-size: 1rem; resize: vertical;"></textarea>
            </div>
            <button type="submit"
                style="padding: 0.75rem 1.5rem; background: #007bff; color: white; border: none; border-radius: 4px; font-size: 1rem; cursor: pointer; transition: background 0.2s; align-self: flex-start;">Create
                Post</button>
        </form>
    </div>

    <div class="posts">
        <h2>Recent Posts</h2>
        <div id="postsList"></div>
    </div>
</div>

<script>
    // Load posts
    async function loadPosts() """),format.raw/*42.32*/("""{"""),format.raw/*42.33*/("""
        """),format.raw/*43.9*/("""const token = document.querySelector('input[name="csrfToken"]').value;
        try """),format.raw/*44.13*/("""{"""),format.raw/*44.14*/("""
            """),format.raw/*45.13*/("""const response = await fetch('/api/posts', """),format.raw/*45.56*/("""{"""),format.raw/*45.57*/("""
                """),format.raw/*46.17*/("""headers: """),format.raw/*46.26*/("""{"""),format.raw/*46.27*/("""
                    """),format.raw/*47.21*/("""'Csrf-Token': token
                """),format.raw/*48.17*/("""}"""),format.raw/*48.18*/("""
            """),format.raw/*49.13*/("""}"""),format.raw/*49.14*/(""");
            const data = await response.json();
            const postsList = document.getElementById('postsList');

            postsList.innerHTML = data.posts.map(postData => `
                    <div class="post">
                        <div class="post-header">
                            <h3>Title: $"""),format.raw/*56.41*/("""{"""),format.raw/*56.42*/("""postData.post.title"""),format.raw/*56.61*/("""}"""),format.raw/*56.62*/("""</h3>
                            <div class="user-info">
                                <span class="username">Author: $"""),format.raw/*58.65*/("""{"""),format.raw/*58.66*/("""postData.user.username"""),format.raw/*58.88*/("""}"""),format.raw/*58.89*/("""</span>
                                $"""),format.raw/*59.34*/("""{"""),format.raw/*59.35*/("""postData.user.username !== '"""),_display_(/*59.64*/username),format.raw/*59.72*/("""' ?
                    `<button 
                                        onclick="toggleFollow($"""),format.raw/*61.64*/("""{"""),format.raw/*61.65*/("""postData.user.id"""),format.raw/*61.81*/("""}"""),format.raw/*61.82*/(""")" 
                                        class="follow-btn $"""),format.raw/*62.60*/("""{"""),format.raw/*62.61*/("""postData.isFollowing ? 'following' : ''"""),format.raw/*62.100*/("""}"""),format.raw/*62.101*/(""""
                                    >
                                        $"""),format.raw/*64.42*/("""{"""),format.raw/*64.43*/("""postData.isFollowing ? 'Unfollow' : 'Follow'"""),format.raw/*64.87*/("""}"""),format.raw/*64.88*/("""
                                    """),format.raw/*65.37*/("""</button>`
                    : ''
                """),format.raw/*67.17*/("""}"""),format.raw/*67.18*/("""
                            """),format.raw/*68.29*/("""</div>
                        </div>
                        <p>Content: $"""),format.raw/*70.38*/("""{"""),format.raw/*70.39*/("""postData.post.body"""),format.raw/*70.57*/("""}"""),format.raw/*70.58*/("""</p>
                        <small>Posted on $"""),format.raw/*71.43*/("""{"""),format.raw/*71.44*/("""new Date(postData.post.createdAt).toLocaleString()"""),format.raw/*71.94*/("""}"""),format.raw/*71.95*/("""</small>
                    </div>
                `).join('');
        """),format.raw/*74.9*/("""}"""),format.raw/*74.10*/(""" """),format.raw/*74.11*/("""catch (error) """),format.raw/*74.25*/("""{"""),format.raw/*74.26*/("""
            """),format.raw/*75.13*/("""console.error('Error:', error);
        """),format.raw/*76.9*/("""}"""),format.raw/*76.10*/("""
    """),format.raw/*77.5*/("""}"""),format.raw/*77.6*/("""

    """),format.raw/*79.5*/("""async function toggleFollow(userId) """),format.raw/*79.41*/("""{"""),format.raw/*79.42*/("""
        """),format.raw/*80.9*/("""const token = document.querySelector('input[name="csrfToken"]').value;
        const button = event.target;
        const isFollowing = button.classList.contains('following');

        try """),format.raw/*84.13*/("""{"""),format.raw/*84.14*/("""
            """),format.raw/*85.13*/("""const response = await fetch(`/api/follow/$"""),format.raw/*85.56*/("""{"""),format.raw/*85.57*/("""userId"""),format.raw/*85.63*/("""}"""),format.raw/*85.64*/("""`, """),format.raw/*85.67*/("""{"""),format.raw/*85.68*/("""
                """),format.raw/*86.17*/("""method: isFollowing ? 'DELETE' : 'POST',
                headers: """),format.raw/*87.26*/("""{"""),format.raw/*87.27*/("""
                    """),format.raw/*88.21*/("""'Csrf-Token': token
                """),format.raw/*89.17*/("""}"""),format.raw/*89.18*/("""
            """),format.raw/*90.13*/("""}"""),format.raw/*90.14*/(""");

            if (response.ok) """),format.raw/*92.30*/("""{"""),format.raw/*92.31*/("""
                """),format.raw/*93.17*/("""button.classList.toggle('following');

                loadPosts();
            """),format.raw/*96.13*/("""}"""),format.raw/*96.14*/(""" """),format.raw/*96.15*/("""else """),format.raw/*96.20*/("""{"""),format.raw/*96.21*/("""
                """),format.raw/*97.17*/("""const error = await response.json();
                alert(error.message || 'Failed to update follow status');
            """),format.raw/*99.13*/("""}"""),format.raw/*99.14*/("""
        """),format.raw/*100.9*/("""}"""),format.raw/*100.10*/(""" """),format.raw/*100.11*/("""catch (error) """),format.raw/*100.25*/("""{"""),format.raw/*100.26*/("""
            """),format.raw/*101.13*/("""console.error('Error:', error);
            alert('Network error occurred');
        """),format.raw/*103.9*/("""}"""),format.raw/*103.10*/("""
    """),format.raw/*104.5*/("""}"""),format.raw/*104.6*/("""

    """),format.raw/*106.5*/("""// Handle post creation
    document.getElementById('createPostForm').addEventListener('submit', async (e) => """),format.raw/*107.87*/("""{"""),format.raw/*107.88*/("""
        """),format.raw/*108.9*/("""e.preventDefault();
        const token = document.querySelector('input[name="csrfToken"]').value;
        const formData = """),format.raw/*110.26*/("""{"""),format.raw/*110.27*/("""
            """),format.raw/*111.13*/("""title: document.getElementById('title').value,
            body: document.getElementById('body').value
        """),format.raw/*113.9*/("""}"""),format.raw/*113.10*/(""";

        try """),format.raw/*115.13*/("""{"""),format.raw/*115.14*/("""
            """),format.raw/*116.13*/("""const response = await fetch('/api/posts', """),format.raw/*116.56*/("""{"""),format.raw/*116.57*/("""
                """),format.raw/*117.17*/("""method: 'POST',
                headers: """),format.raw/*118.26*/("""{"""),format.raw/*118.27*/("""
                    """),format.raw/*119.21*/("""'Content-Type': 'application/json',
                    'Csrf-Token': token
                """),format.raw/*121.17*/("""}"""),format.raw/*121.18*/(""",
                body: JSON.stringify(formData)
            """),format.raw/*123.13*/("""}"""),format.raw/*123.14*/(""");

            if (response.ok) """),format.raw/*125.30*/("""{"""),format.raw/*125.31*/("""
                """),format.raw/*126.17*/("""document.getElementById('createPostForm').reset();
                loadPosts();
            """),format.raw/*128.13*/("""}"""),format.raw/*128.14*/(""" """),format.raw/*128.15*/("""else """),format.raw/*128.20*/("""{"""),format.raw/*128.21*/("""
                """),format.raw/*129.17*/("""alert('Failed to create post');
            """),format.raw/*130.13*/("""}"""),format.raw/*130.14*/("""
        """),format.raw/*131.9*/("""}"""),format.raw/*131.10*/(""" """),format.raw/*131.11*/("""catch (error) """),format.raw/*131.25*/("""{"""),format.raw/*131.26*/("""
            """),format.raw/*132.13*/("""console.error('Error:', error);
        """),format.raw/*133.9*/("""}"""),format.raw/*133.10*/("""
    """),format.raw/*134.5*/("""}"""),format.raw/*134.6*/(""");

    // Load posts when page loads
    loadPosts();
</script>
<script>
    // Load posts when page loads
    loadPosts();
</script>
""")))}))
      }
    }
  }

  def render(username:String,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(username)(request)

  def f:((String) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (username) => (request) => apply(username)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 45aaec3b174239d86d95631e44e9b74d408da7ba
                  MATRIX: 743->1|889->52|919->57|939->69|978->71|1006->73|1071->112|1099->120|1161->156|1175->162|1220->187|1294->235|1308->241|1352->265|1773->659|1788->665|1824->680|1866->694|3138->1938|3167->1939|3204->1949|3316->2033|3345->2034|3387->2048|3458->2091|3487->2092|3533->2110|3570->2119|3599->2120|3649->2142|3714->2179|3743->2180|3785->2194|3814->2195|4161->2514|4190->2515|4237->2534|4266->2535|4418->2659|4447->2660|4497->2682|4526->2683|4596->2725|4625->2726|4681->2755|4710->2763|4837->2862|4866->2863|4910->2879|4939->2880|5031->2944|5060->2945|5128->2984|5158->2985|5269->3068|5298->3069|5370->3113|5399->3114|5465->3152|5547->3206|5576->3207|5634->3237|5739->3314|5768->3315|5814->3333|5843->3334|5919->3382|5948->3383|6026->3433|6055->3434|6158->3510|6187->3511|6216->3512|6258->3526|6287->3527|6329->3541|6397->3582|6426->3583|6459->3589|6487->3590|6522->3598|6586->3634|6615->3635|6652->3645|6873->3838|6902->3839|6944->3853|7015->3896|7044->3897|7078->3903|7107->3904|7138->3907|7167->3908|7213->3926|7308->3993|7337->3994|7387->4016|7452->4053|7481->4054|7523->4068|7552->4069|7615->4104|7644->4105|7690->4123|7801->4206|7830->4207|7859->4208|7892->4213|7921->4214|7967->4232|8120->4357|8149->4358|8187->4368|8217->4369|8247->4370|8290->4384|8320->4385|8363->4399|8478->4486|8508->4487|8542->4493|8571->4494|8607->4502|8747->4613|8777->4614|8815->4624|8970->4750|9000->4751|9043->4765|9184->4878|9214->4879|9260->4896|9290->4897|9333->4911|9405->4954|9435->4955|9482->4973|9553->5015|9583->5016|9634->5038|9757->5132|9787->5133|9879->5196|9909->5197|9973->5232|10003->5233|10050->5251|10173->5345|10203->5346|10233->5347|10267->5352|10297->5353|10344->5371|10418->5416|10448->5417|10486->5427|10516->5428|10546->5429|10589->5443|10619->5444|10662->5458|10731->5499|10761->5500|10795->5506|10824->5507
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|30->5|30->5|32->7|32->7|32->7|33->8|33->8|33->8|42->17|42->17|42->17|43->18|67->42|67->42|68->43|69->44|69->44|70->45|70->45|70->45|71->46|71->46|71->46|72->47|73->48|73->48|74->49|74->49|81->56|81->56|81->56|81->56|83->58|83->58|83->58|83->58|84->59|84->59|84->59|84->59|86->61|86->61|86->61|86->61|87->62|87->62|87->62|87->62|89->64|89->64|89->64|89->64|90->65|92->67|92->67|93->68|95->70|95->70|95->70|95->70|96->71|96->71|96->71|96->71|99->74|99->74|99->74|99->74|99->74|100->75|101->76|101->76|102->77|102->77|104->79|104->79|104->79|105->80|109->84|109->84|110->85|110->85|110->85|110->85|110->85|110->85|110->85|111->86|112->87|112->87|113->88|114->89|114->89|115->90|115->90|117->92|117->92|118->93|121->96|121->96|121->96|121->96|121->96|122->97|124->99|124->99|125->100|125->100|125->100|125->100|125->100|126->101|128->103|128->103|129->104|129->104|131->106|132->107|132->107|133->108|135->110|135->110|136->111|138->113|138->113|140->115|140->115|141->116|141->116|141->116|142->117|143->118|143->118|144->119|146->121|146->121|148->123|148->123|150->125|150->125|151->126|153->128|153->128|153->128|153->128|153->128|154->129|155->130|155->130|156->131|156->131|156->131|156->131|156->131|157->132|158->133|158->133|159->134|159->134
                  -- GENERATED --
              */
          