<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/headerManage.jsp" %>

<div class="about">
    <div class="container_width">
        <div class="row d_flex">
            <div class="col-md-6">
                <div class="titlepage text_align_left">
                    <h2> Customer </h2>
                    <h1 class="mt-3">Customer</h1>
                    
                    <div class="detail-info">
                        <div class="pl-5 pb-2 col-md-12">
                            <div class="row d_flex ">
                                <li class="col-md-4">UserID </li >
                                <li class="col-md-8 font-weight-bolder">${schedule.user.id}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-4">Name</li >
                                <li class="col-md-8 font-weight-bolder">${schedule.user.name}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-4">Phone </li >
                                <li class="col-md-8 font-weight-bolder">${schedule.user.phone}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-4">DOB </li >
                                <li class="col-md-8 font-weight-bolder">${schedule.user.dobString}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-4">Gender</li >
                                <li class="col-md-8 font-weight-bolder">${schedule.user.gender}</li>
                            </div> 
                            <div class="row d_flex">
                                <li class="col-md-4">VCS Number</li >
                                <li class="col-md-8 font-weight-bolder">${schedule.user.numOfVaccine}</li>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="titlepage-right text_align_left">
                    <h2> Vaccination Schedule </h2>
                    <h1 class="mt-3">Schedule</h1>

                    <div class="detail-info">
                        <div class="pl-5 pb-2 col-md-12">
                            <div class="row d_flex ">
                                <li class="col-md-5">ScheduleID </li >
                                <li class="font-weight-bolder">${schedule.scheduleID}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-5">Vaccination Time </li >
                                <li class="font-weight-bolder">${schedule.timeString}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-5">Place </li >
                                <li class="font-weight-bolder">${schedule.site.place.location}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-5">VaccineID </li >
                                <li class="font-weight-bolder">${schedule.site.vaccine.vaccineID}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-5">Vaccine Name </li >
                                <li class="font-weight-bolder">${schedule.site.vaccine.type.typeName}</li>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="staff-info">
                    <h1 class="mt-3">Staff</h1>

                    <div class="detail-info">
                        <div class="pl-5 pb-2 col-md-12">
                            <div class="row d_flex ">
                                <li class="col-md-3">StaffID </li >
                                <li class="col-md-9 font-weight-bolder">${schedule.staff.id}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-3">Name</li >
                                <li class="col-md-9 font-weight-bolder">${schedule.staff.name}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-3">Phone </li >
                                <li class="col-md-9 font-weight-bolder">${schedule.staff.phone}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-3">DOB </li >
                                <li class="col-md-9 font-weight-bolder">${schedule.staff.dobString}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-3">Gender</li >
                                <li class="col-md-9 font-weight-bolder">${schedule.staff.gender}</li>
                            </div>
                            <div class="row d_flex">
                                <li class="col-md-3">Input Date</li >
                                <li class="col-md-9 font-weight-bolder">${schedule.dateInputString}</li>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="/includes/footer.jsp" %>






<!--                    <div class="d_flex detail-info">
                        <div class="col-md-3">
                            <ul class="pl-5 pb-2">
                                <li>UserID</li>
                                <li>Name</li>
                                <li>Phone</li>
                                <li>DOB</li>
                                <li>Gender</li>
                            </ul>
                        </div>
                        <div class="col-md-9">
                            <ul class="pl-5 pb-2 ul-fw-bolder">
                                <li>${schedule.user.id}</li>
                                <li>${schedule.user.name}</li>
                                <li>${schedule.user.phone}</li>
                                <li>${schedule.user.dobString}</li>
                                <li>${schedule.user.gender}</li>
                            </ul>
                        </div>
                    </div>-->