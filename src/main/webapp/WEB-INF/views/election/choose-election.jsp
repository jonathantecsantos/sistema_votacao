<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../taglibs.jsp"%>

<sistema:template titulo="Dê o seu voto">
	
	<sistema:message/>
	<form:form action="/votingbooth/choose/election" modelAttribute="chooseElectionForm" method="get">
        <div class="col-md-8 col-sm-12 mx-auto common-margin-bottom">
                <div class="row common-margin-bottom">
                    <div class="form-group d-block col-12">
                        <label for="electionId">Eleição</label>
                        <form:select path="electionId" items="${elections}" itemLabel="name" itemValue="id" class="custom-select custom-select-lg"/>
                        <form:errors path="electionId"/>
                    </div>
                </div>
         </div>         
         <div class="row">
             <button type="submit" class="btn btn-success col-md-6 col-sm-6 col-xs-6 mx-auto">
                 Votar
             </button>
         </div>		
	</form:form>
</sistema:template>