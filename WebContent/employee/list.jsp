<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
    <div class="text-list">
        <h3>Employee List</h3>
    </div>
</div>
<div class="col-12">
    <div class="row">
    	<form class="d-flex float-end" method="get">
	        <input class="form-control me-2" type="search" name="search" value="${search}" placeholder="Search" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">Search</button>
      	</form>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Date of birth</th>
                    <th>Address</th>
                    <th>Phone number</th>
                    <th>Department</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${employees }" var="employee">
            		<tr>
                     <td>${employee.employeeId }</td>
                     <td>${employee.firstName } ${employee.lastName}</td>
                     <td>${employee.dateOfBirth }</td>
                     <td>${employee.address }</td>
                     <td>${employee.phone }</td>
                     <td>${employee.departmentName}</td>
                     <td>
                     	<a id="" class="btn btn-success" href="profile?empId=${employee.employeeId }" role="button">View</a> 
                        <a id="" class="btn btn-primary" href="edit?empId=${employee.employeeId }" role="button">Edit</a> 
                        <a id="" class="btn btn-danger" onclick="openModalConfirmDelete(${employee.employeeId})" role="button">Delete</a>                    
                     </td>
                	</tr> 
            	</c:forEach>
                                          
            </tbody>
        </table>
    </div>
    <div class="row ">
		<div class="col">
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-center">
					<li class="page-item "><a class="page-link" href="list?index=${indexPage-1}${search != null ? '&search=': ''}${search != null ? search : ''}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<c:forEach var="i" begin="1" end="${totalPage}">
						<li class="page-item ${indexPage == i ? 'active' : '' }"><a class="page-link"  
						href="list?index=${i}${search != null ? '&search=' : ''}${search != null ? search : ''}">${i}</a></li>
						<!-- <li class="page-item"><a class="page-link" href="#">2</a></li> -->
					</c:forEach>
					
					<li class="page-item"><a class="page-link" href="list?index=${indexPage+1}${search != null ? '&search=': ''}${search != null ? search : ''}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span	
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>

