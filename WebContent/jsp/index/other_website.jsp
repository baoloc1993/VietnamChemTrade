<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="other-websites">
        <div class="product-bg" style=" padding-bottom: 15%;color: #ffffff; width: 100%; font-size:15px;">OTHER WEBSITES<br>
           <div class="product-txt" style="margin-top: 5px;"><br>Select Other Websites:</div>
                     <select title="Other Websites" onchange="if (this.value) window.open(this.options[this.selectedIndex].value,'_blank')" style="width:95%;" class="other-pdt-drop" name="other_website" id="other_website">
<option value="">Select Other Websites</option>

<c:forEach items="${otherWebsites}" var="website">
			<option value= "<c:out value = "${website.link}"/>"><c:out value = "${website.name}"/></option>
</c:forEach>	

</select>          
        
           <!--<button class="go-btn" onclick="window.open($('select[id=other-pdt-drop]').val());"></button>-->
        
        </div>
        </div>
        