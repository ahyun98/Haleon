<template>
  <div class = "workout">
      <div class = "comp">
          <div style = "padding: 100px 0px">
        <div class = "week"> </div>
        <div class = "weekcheck">
            <div class = "daycheck" v-for="(day,index) in week" :key="index">
                <div>{{day}}</div>
                <img v-show="is_Exercise[index]" class = "check" src = "@/assets/check.png">
            </div>
        </div>
        <div style = "text-align:right; right:10vw; margin-bottom:10px">지금까지 {{profile.period}}일 운동 중!</div>
        <div class = "profile" style = "padding-top: 100px; padding-bottom: 100px;">
            <div class = "profile_1">
                <img v-show="user.gender=='woman'" class = "profileimg" src="@/assets/woman.png" alt="">
                <img v-show="user.gender=='man'" class = "profileimg" src="@/assets/man.png" alt="">
                <div class = "profilename">
                    <span style = "font-size:35px; font-weight:bold;">{{user.username}}님</span><span style = "text-align:end;">{{profile.age}}</span><br><br>
                    <div>{{profile.height}}cm  / {{profile.weight}}kg</div>
                </div>
                <div >
                    <p>체지방률 {{profile.fatRate}}</p>
                    <p>근육량 {{profile.muscleRate}}</p>
                    <p>BMI 지수 {{profile.bmi}}</p>
                </div>
                <div>
                    <button class = "routineAddbtn">Routine 생성</button><br><br>
                    <button class = "routineAddbtn" @click="profileEditForm">+ edit</button>
                </div>
            </div>
            <div class = "profile_2" style = "padding-top:60px;">
                <h2 style = "padding-right:65vw;">Today's Workout</h2>
                <div style = "display: flex; justify-content:space-between; align-items:center;">
                    <p style = "font-size : 30px;">총 운동 시간</p>
                    <p style = "font-size : 20px;">{{workHour}}시간 {{workMinute}}분</p>
                    <div>
                        <p>섭취 Calories</p>
                        <p>Burn Calories</p>
                    </div>
                    <div>
                        <p>{{workout.cal}} cal</p>
                        <p>{{workout.burn}} cal</p>
                    </div>
                    <div>
                        <button class = "routineAddbtn" >+ Routine</button><br><br>
                        <button class = "routineAddbtn" @click="workoutEditForm">+ edit</button>
                    </div>
                </div>
            </div>
            <div class = "profile_2" style = "padding-top:60px;">
                <h4 style = "padding-right:70vw; ">Today's Exercise</h4>
                <div style = "display: flex; justify-content:space-around;">

                    <div>
                        <div>Cardio</div>
                        <div v-show="exercise.card1>0">싸이클 : {{exercise.card1}} set</div>
                        <div v-show="exercise.card2>0">트레드밀 : {{exercise.card2}} set</div>
                        <div v-show="exercise.card3>0">조깅 : {{exercise.card3}} set</div>
                        <div v-show="exercise.card4>0">요가 : {{exercise.card4}} set</div>
                        <div v-show="exercise.card5>0">필라테스 : {{exercise.card5}} set</div>
                    </div>
                    
                    <div>
                        <div>하체</div>
                        <div v-show="exercise.weight1>0">바벨 백스쿼트 : {{exercise.weight1}} set</div>
                        <div v-show="exercise.weight2>0">프론트 스쿼트 : {{exercise.weight2}} set</div>
                        <div v-show="exercise.weight3>0">레그 프레스 : {{exercise.weight3}} set</div>
                        <div v-show="exercise.weight4>0">레그 컬 : {{exercise.weight4}} set</div>
                        <div v-show="exercise.weight5>0">레그 익스텐션 : {{exercise.weight5}} set</div>
                        <div v-show="exercise.weight6>0">덤벨 런지 : {{exercise.weight6}} set</div>
                        <div v-show="exercise.weight7>0">데드 리프트 : {{exercise.weight7}} set</div>
                        <div v-show="exercise.weight8>0">이너 싸이 : {{exercise.weight8}} set</div>
                        <div v-show="exercise.weight9>0">힙 쓰러스트 : {{exercise.weight9}} set</div>
                    </div>
                    <div>
                        <div>가슴</div>
                        <div v-show="exercise.chest1>0"> 벤치프레스 : {{exercise.chest1}} set</div>
                        <div v-show="exercise.chest2>0"> 덤벨 플라이 : {{exercise.chest2}} set</div>
                        <div v-show="exercise.chest3>0"> 푸쉬업 : {{exercise.chest3}} set</div>
                        <div v-show="exercise.chest4>0"> 체스트 프레스 : {{exercise.chest4}} set</div>
                    </div>
                    <div>
                        <div>등</div>
                        <div v-show="exercise.back1>0">풀업 : {{exercise.back1}} set</div>
                        <div v-show="exercise.back2>0">덤벨 로우 : {{exercise.back2}} set</div>
                        <div v-show="exercise.back3>0">시티드 로우 : {{exercise.back3}} set</div>
                        <div v-show="exercise.back4>0">랫풀다운 : {{exercise.back4}} set</div>
                        <div v-show="exercise.back5>0">시티드 케이블 로우 : {{exercise.back5}} set</div>

                    </div>
                    <div>
                        <div>어깨</div>
                        <div v-show="exercise.shoul1>0">오버헤드 프레스 : {{exercise.shoul1}} set</div>
                        <div v-show="exercise.shoul2>0">덤벨 숄더 프레스 : {{exercise.shoul2}} set</div>
                        <div v-show="exercise.shoul3>0">덤벨 레터럴 레이즈 : {{exercise.shoul3}} set</div>
                        <div v-show="exercise.shoul4>0">덤벨 프론트 레이즈 : {{exercise.shoul4}} set</div>
                        <div v-show="exercise.shoul5>0">사이드 레터럴 레이즈 : {{exercise.shoul5}} set</div>
                        <div v-show="exercise.shoul6>0">바벨 업라이트 로우 : {{exercise.shoul6}} set</div>
                        <div v-show="exercise.shoul7>0">숄더 프레스 머신 : {{exercise.shoul7}} set</div>

                    </div>
                    <div>
                        <div>팔</div>
                        <div v-show="exercise.arm1>0">바벨컬 : {{exercise.arm1}} set</div>
                        <div v-show="exercise.arm2>0">덤벨 컬 : {{exercise.arm2}} set</div>
                        <div v-show="exercise.arm3>0">덤벨 킥백 : {{exercise.arm3}} set</div>
                        <div v-show="exercise.arm4>0">덤벨 삼두 익스텐션 : {{exercise.arm4}} set</div>
                        <div v-show="exercise.arm5>0">덤벨 리스트 컬 : {{exercise.arm5}} set</div>

                    </div>
                    <div>
                        <div>복근</div>
                        <div v-show="exercise.abs1>0">싯업 : {{exercise.abs1}} set</div>
                        <div v-show="exercise.abs2>0">레그 레이즈 : {{exercise.abs2}} set</div>
                        <div v-show="exercise.abs3>0">러시안 트위스트 : {{exercise.abs3}} set</div>
                        <div v-show="exercise.abs4>0">플랭크 : {{exercise.abs4}} set</div>
                        <div v-show="exercise.abs5>0">브이업 : {{exercise.abs5}} set</div>
                        <div v-show="exercise.abs6>0">크런치 : {{exercise.abs6}} set</div>
                        <div v-show="exercise.abs7>0">복근 크런치 머신 : {{exercise.abs7}} set</div>

                    </div>
                </div>
            </div>
                        
                        
            <button class = "routineAddbtn" @click="addform" style = "margin-top:100px;">운동 추가</button>
            <div v-show="isAdd">
            <div class = "profile_3" style = "padding-top:60px">
                <h2 style = "padding-right:71.5vw">Cardio</h2>
                <div>
                    <b-form-checkbox-group
                        id="checkbox-group-2"
                        v-model="selected"
                        name="flavour-2"
                    >   
                        <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="card1" style = "padding-right : 30px;">싸이클</b-form-checkbox><br>
                            <span v-if="selected.indexOf('card1')!=-1">
                                <b-form-select v-model="card1" :options="options" style = "background-color : #212323; color: white; height:30px;"></b-form-select>
                            </span>
                        </div>
                        <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="card2" style = "padding-right : 30px;">트레드밀</b-form-checkbox><br>
                            <span v-if="selected.indexOf('card2')!=-1">
                                <b-form-select v-model="card2" :options="options" style = "background-color : #212323; color: white; height:30px;"></b-form-select>
                            </span>
                        </div>
                        <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="card3" style = "padding-right : 30px;">조깅</b-form-checkbox><br>
                            <span v-if="selected.indexOf('card3')!=-1">
                                <b-form-select v-model="card3" :options="options" style = "background-color : #212323; color: white; height:30px;"></b-form-select>
                            </span>
                        </div>
                        <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="card4" style = "padding-right : 30px;">요가</b-form-checkbox><br>
                            <span v-if="selected.indexOf('card4')!=-1">
                                <b-form-select v-model="card4" :options="options" style = "background-color : #212323; color: white; height:30px;"></b-form-select>
                            </span>
                        </div>
                        <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="card5" style = "padding-right : 30px;">필라테스</b-form-checkbox><br>
                            <span v-if="selected.indexOf('card5')!=-1">
                                <b-form-select v-model="card5" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                        </div>
                    </b-form-checkbox-group>
                </div>
            </div>
            <div class = "profile_4" style = "padding-top:60px">
                <h2 style = "padding-right:71.5vw">Weight</h2>
                <div>
                     <div>
                        <div class="mb-3">
                        <b-button v-b-toggle.my-collapse1>하체</b-button>
                        <b-button v-b-toggle.my-collapse2>가슴</b-button>
                        <b-button v-b-toggle.my-collapse3>등</b-button>
                        <b-button v-b-toggle.my-collapse4>어깨</b-button>
                        <b-button v-b-toggle.my-collapse5>팔</b-button>
                        <b-button v-b-toggle.my-collapse6>복근</b-button>
                        </div>

                        <b-collapse id="my-collapse1">
                        <b-card title="하체" style = "background-color:#212323">
                            <b-form-checkbox-group
                                id="checkbox-group-2"
                                v-model="selected"
                                name="flavour-2"
                            >


                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="weight1" style = "padding-right : 30px;">바벨 백스쿼트</b-form-checkbox><br>
                            <span v-if="selected.indexOf('weight1')!=-1">
                                <b-form-select v-model="weight1" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="weight2" style = "padding-right : 30px;">프론트 스쿼트</b-form-checkbox><br>
                            <span v-if="selected.indexOf('weight2')!=-1">
                                <b-form-select v-model="weight2" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="weight3" style = "padding-right : 30px;">레그 프레스</b-form-checkbox><br>
                            <span v-if="selected.indexOf('weight3')!=-1">
                                <b-form-select v-model="weight3" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="weight4" style = "padding-right : 30px;">레그 컬</b-form-checkbox><br>
                            <span v-if="selected.indexOf('weight4')!=-1">
                                <b-form-select v-model="weight4" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="weight5" style = "padding-right : 30px;">레그 익스텐션</b-form-checkbox><br>
                            <span v-if="selected.indexOf('weight5')!=-1">
                                <b-form-select v-model="weight5" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="weight6" style = "padding-right : 30px;">덤벨 런지</b-form-checkbox><br>
                            <span v-if="selected.indexOf('weight6')!=-1">
                                <b-form-select v-model="weight6" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="weight7" style = "padding-right : 30px;">데드 리프트</b-form-checkbox><br>
                            <span v-if="selected.indexOf('weight7')!=-1">
                                <b-form-select v-model="weight7" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="weight8" style = "padding-right : 30px;">이너 싸이</b-form-checkbox><br>
                            <span v-if="selected.indexOf('weight8')!=-1">
                                <b-form-select v-model="weight8" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="weight9" style = "padding-right : 30px;">힙 쓰러스트</b-form-checkbox><br>
                            <span v-if="selected.indexOf('weight9')!=-1">
                                <b-form-select v-model="weight9" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                            </b-form-checkbox-group>
                        </b-card>
                        </b-collapse>
                        <b-collapse id="my-collapse2">
                        <b-card title="가슴" style = "background-color:#212323">
                            <b-form-checkbox-group
                                id="checkbox-group-2"
                                v-model="selected"
                                name="flavour-2"
                            >

                                 <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="chest1" style = "padding-right : 30px;">벤치프레스</b-form-checkbox><br>
                            <span v-if="selected.indexOf('chest1')!=-1">
                                <b-form-select v-model="chest1" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="chest2" style = "padding-right : 30px;">덤벨 플라이</b-form-checkbox><br>
                            <span v-if="selected.indexOf('chest2')!=-1">
                                <b-form-select v-model="chest2" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="chest3" style = "padding-right : 30px;">푸쉬업</b-form-checkbox><br>
                            <span v-if="selected.indexOf('chest3')!=-1">
                                <b-form-select v-model="chest3" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="chest4" style = "padding-right : 30px;">체스트프레스</b-form-checkbox><br>
                            <span v-if="selected.indexOf('chest4')!=-1">
                                <b-form-select v-model="chest4" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>
                            </b-form-checkbox-group>
                        </b-card>
                        </b-collapse>
                        <b-collapse id="my-collapse3">
                        <b-card title="등" style = "background-color:#212323">
                            <b-form-checkbox-group
                                id="checkbox-group-2"
                                v-model="selected"
                                name="flavour-2"
                            >

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="back1" style = "padding-right : 30px;">풀업</b-form-checkbox><br>
                            <span v-if="selected.indexOf('back1')!=-1">
                                <b-form-select v-model="back1" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="back2" style = "padding-right : 30px;">덤벨 로우</b-form-checkbox><br>
                            <span v-if="selected.indexOf('back2')!=-1">
                                <b-form-select v-model="back2" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="back3" style = "padding-right : 30px;">시티드로우</b-form-checkbox><br>
                            <span v-if="selected.indexOf('back3')!=-1">
                                <b-form-select v-model="back3" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="back4" style = "padding-right : 30px;">랫풀다운</b-form-checkbox><br>
                            <span v-if="selected.indexOf('back4')!=-1">
                                <b-form-select v-model="back4" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="back5" style = "padding-right : 30px;">시티드 케이블 로우</b-form-checkbox><br>
                            <span v-if="selected.indexOf('back5')!=-1">
                                <b-form-select v-model="back5" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                            </b-form-checkbox-group>
                        </b-card>
                        </b-collapse>
                        <b-collapse id="my-collapse4">
                        <b-card title="어깨" style = "background-color:#212323">
                            <b-form-checkbox-group
                                id="checkbox-group-2"
                                 v-model="selected"
                                name="flavour-2"
                            >

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="shoul1" style = "padding-right : 30px;">오버헤드 프레스</b-form-checkbox><br>
                            <span v-if="selected.indexOf('shoul1')!=-1">
                                <b-form-select v-model="shoul1" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="shoul2" style = "padding-right : 30px;">덤벨 숄더 프레스</b-form-checkbox><br>
                            <span v-if="selected.indexOf('shoul2')!=-1">
                                <b-form-select v-model="shoul2" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="shoul3" style = "padding-right : 30px;">덤벨 레터럴 레이즈</b-form-checkbox><br>
                            <span v-if="selected.indexOf('shoul3')!=-1">
                                <b-form-select v-model="shoul3" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="shoul4" style = "padding-right : 30px;">덤벨 프론트 레이즈</b-form-checkbox><br>
                            <span v-if="selected.indexOf('shoul4')!=-1">
                                <b-form-select v-model="shoul4" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="shoul5" style = "padding-right : 30px;">사이드 레터럴 레이즈</b-form-checkbox><br>
                            <span v-if="selected.indexOf('shoul5')!=-1">
                                <b-form-select v-model="shoul5" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="shoul6" style = "padding-right : 30px;">바벨 업라이트 로우</b-form-checkbox><br>
                            <span v-if="selected.indexOf('shoul6')!=-1">
                                <b-form-select v-model="shoul6" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="shoul7" style = "padding-right : 30px;">숄더 프레스 머신</b-form-checkbox><br>
                            <span v-if="selected.indexOf('shoul7')!=-1">
                                <b-form-select v-model="shoul7" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                            </b-form-checkbox-group>
                        </b-card>
                        </b-collapse>
                        <b-collapse id="my-collapse5">
                        <b-card title="팔" style = "background-color:#212323">
                            <b-form-checkbox-group
                                id="checkbox-group-2"
                                 v-model="selected"
                                name="flavour-2"
                            >

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="arm1" style = "padding-right : 30px;">바벨컬</b-form-checkbox><br>
                            <span v-if="selected.indexOf('arm1')!=-1">
                                <b-form-select v-model="arm1" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="arm2" style = "padding-right : 30px;">덤벨 컬</b-form-checkbox><br>
                            <span v-if="selected.indexOf('arm2')!=-1">
                                <b-form-select v-model="arm2" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="arm3" style = "padding-right : 30px;">덤벨 킥백</b-form-checkbox><br>
                            <span v-if="selected.indexOf('arm3')!=-1">
                                <b-form-select v-model="arm3" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="arm4" style = "padding-right : 30px;">덤벨 삼두 익스텐션</b-form-checkbox><br>
                            <span v-if="selected.indexOf('arm4')!=-1">
                                <b-form-select v-model="arm4" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                              <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="arm5" style = "padding-right : 30px;">덤벨 리스트 컬</b-form-checkbox><br>
                            <span v-if="selected.indexOf('arm5')!=-1">
                                <b-form-select v-model="arm5" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>


                            </b-form-checkbox-group>
                        </b-card>
                        </b-collapse>
                        <b-collapse id="my-collapse6">
                        <b-card title="복근" style = "background-color:#212323">
                            <b-form-checkbox-group
                                id="checkbox-group-2"
                                v-model="selected"
                                name="flavour-2"
                            >

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="abs1" style = "padding-right : 30px;">싯업</b-form-checkbox><br>
                            <span v-if="selected.indexOf('abs1')!=-1">
                                <b-form-select v-model="abs1" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="abs2" style = "padding-right : 30px;">레그 레이즈</b-form-checkbox><br>
                            <span v-if="selected.indexOf('abs2')!=-1">
                                <b-form-select v-model="abs2" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="abs3" style = "padding-right : 30px;">러시안 트위스트</b-form-checkbox><br>
                            <span v-if="selected.indexOf('abs3')!=-1">
                                <b-form-select v-model="abs3" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="abs4" style = "padding-right : 30px;">플랭크</b-form-checkbox><br>
                            <span v-if="selected.indexOf('abs4')!=-1">
                                <b-form-select v-model="abs4" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="abs5" style = "padding-right : 30px;">브이업</b-form-checkbox><br>
                            <span v-if="selected.indexOf('abs5')!=-1">
                                <b-form-select v-model="abs5" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="abs6" style = "padding-right : 30px;">크런치</b-form-checkbox><br>
                            <span v-if="selected.indexOf('abs6')!=-1">
                                <b-form-select v-model="abs6" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                             <div style="display:flex; justify-content: flex-start;">
                            <b-form-checkbox size="lg" value="abs7" style = "padding-right : 30px;">복근 크런치 머신</b-form-checkbox><br>
                            <span v-if="selected.indexOf('abs7')!=-1">
                                <b-form-select v-model="abs7" :options="options" style = "background-color : #212323; color: white; "></b-form-select>
                            </span>
                            </div>

                            </b-form-checkbox-group>
                        </b-card>
                        </b-collapse>
                     </div>
                     
                    <button class = "routineAddbtn" @click="addExercise">운동 등록</button><br><br>
                </div>
            </div>
            </div>


            <div class = "profile_5" style = "padding-top:60px">
                <h2 style = "padding-right:71.5vw">Watch</h2> 
                <div style = "display:flex; justify-content: space-around;">

                    <div class = "movie" v-for="(video,index) in videolog" :key = index>
                    <iframe style = "width : 250px;" :src = "`https://www.youtube.com/embed/${video.videoId}`" frameborder=0></iframe>
                    </div>
                </div>
            </div>
            <div class = "profile_6" style = "padding-top:60px">
                <button class = "routineAddbtn" @click="getExercises">일지 조회</button><br><br>
            </div>
            </div>
        </div>
      </div>
    </div>

</template>

<script>
import { mapState } from 'vuex';

const dates = [];
let index = 0;
    const today = new Date();
    const day = today.getDay();
for (let i = -1*day+1; i < 8-day; i++) {
    const today = new Date();
    const d = new Date(today.setDate(today.getDate() + i));
    dates[index++] =  d.getFullYear() + "-" + ((d.getMonth() + 1) > 9 ? (d.getMonth() + 1).toString() : "0" + (d.getMonth() + 1)) + "-" + (d.getDate() > 9 ? d.getDate().toString() : "0" + d.getDate().toString());
    
}

const todayformat =  today.getFullYear() + "-" + ((today.getMonth() + 1) > 9 ? (today.getMonth() + 1).toString() : "0" + (today.getMonth() + 1)) + "-" + (today.getDate() > 9 ? today.getDate().toString() : "0" + today.getDate().toString());
export default {
    name : "UserProfileView",
    data(){
        return{
            isAdd : false,
            week : ["Mon","Tue","Wed","Thu","Fri","Sat","Sun"],
            selected:[],
            exerciselist:[],
            date:todayformat,
                card1 : 0,
                card2 : 0,
                card3 : 0,
                card4 : 0,
                card5 : 0,
                weight1 : 0,
                weight2 : 0,
                weight3 : 0,
                weight4 : 0,
                weight5 : 0,
                weight6 : 0,
                weight7 : 0,
                weight8 : 0,
                weight9 : 0,
                chest1:0,
                chest2:0,
                chest3:0,
                chest4:0,
                back1 : 0,
                back2 : 0,
                back3 : 0,
                back4 : 0,
                back5 : 0,
                shoul1 : 0,
                shoul2 : 0,
                shoul3 : 0,
                shoul4 : 0,
                shoul5 : 0,
                shoul6 : 0,
                arm1 : 0,
                arm2 : 0,
                arm3 : 0,
                arm4 : 0,
                arm5 : 0,
                arm6 : 0,
                abs1 : 0,
                abs2 : 0,
                abs3 : 0,
                abs4 : 0,
                abs5 : 0,
                abs6 : 0,
                abs7 : 0,
            options: [
                { value: 1, text: '1 Set' },
                { value: 2, text: '2 Set' },
                { value: 3, text: '3 Set' },
                { value: 4, text: '4 Set' },
                { value: 5, text: '5 Set' },
            ],
            dates:dates,
            workHour:"",
            workMinute:"",
        }
    },
    computed: {
        ...mapState([
            "profile",
            "workout",
            "exercise",
            "is_Exercise",
            "user",
            "videolog"
        ])
    },
    created(){
        const id = sessionStorage.getItem("id");
        this.$store.dispatch('getProfile',id);
        let payload = {
            id : id,
            regDate : this.date,
        }
        this.$store.dispatch('getExercise',payload);
        this.$store.dispatch('getWorkout',payload)
        for (let i = 0; i < this.dates.length; i++) {
            let data = {
                id : id,
            regDate : this.dates[i],
            };
            this.$store.dispatch('isExercise',data);
        }
        this.$store.dispatch("getUser",id);
        this.$store.dispatch("getVideolog",id)
    },
    mounted(){
        const id = sessionStorage.getItem("id");
        let workout = {
            id : id,
            regDate : this.date,
        }

        this.$store.dispatch("addWorkout",workout)

    },
    updated(){
        this.workHour = parseInt(this.workout.workTime / 60);
        this.workMinute = this.workout.workTime-this.workHour*60;
    },
    methods:{
        addExercise(){
            const id = sessionStorage.getItem("id");
            let payload = {
                id : id,
                regDate:this.date,
                card1 : this.card1,
                card2 : this.card2,
                card3 : this.card3,
                card4 : this.card4,
                card5 : this.card5,
                weight1 : this.weight1,
                weight2 : this.weight2,
                weight3 : this.weight3,
                weight4 : this.weight4,
                weight5 : this.weight5,
                weight6 : this.weight6,
                weight7 : this.weight7,
                weight8 : this.weight8,
                weight9 : this.weight9,
                chest1:this.chest1,
                chest2:this.chest2,
                chest3:this.chest3,
                chest4:this.chest4,
                back1 : this.back1,
                back2 : this.back2,
                back3 : this.back3,
                back4 : this.back4,
                back5 : this.back5,
                shoul1 : this.shoul1,
                shoul2 : this.shoul2,
                shoul3 : this.shoul3,
                shoul4 : this.shoul4,
                shoul5 : this.shoul5,
                shoul6 : this.shoul6,
                arm1 : this.arm1,
                arm2 : this.arm2,
                arm3 : this.arm3,
                arm4 : this.arm4,
                arm5 : this.arm5,
                arm6 : this.arm6,
                abs1 : this.abs1,
                abs2 : this.abs2,
                abs3 : this.abs3,
                abs4 : this.abs4,
                abs5 : this.abs5,
                abs6 : this.abs6,
                abs7 : this.abs7,
            }
            this.$store.dispatch("addExercise",payload)
            for (let i = 0; i < this.dates.length; i++) {
            let data1 = {
                id : id,
                regDate : this.dates[i],
            };
            this.$store.dispatch('isExercise',data1);
            let data = {
            id : id,
            regDate : this.date,
            }
            this.$store.dispatch('getExercise',data);
            console.log(this.is_Exercise)
        }
        },
        addform(){
            this.isAdd=!this.isAdd;
        },
        getExercises(){
            this.$router.push("/exerciselist")
        },
        workoutEditForm(){
            this.$router.push("/workoutEdit")
        },
        profileEditForm(){
            this.$router.push("/profileEdit")
        }
    }

}
</script>

<style scoped>
*{
  font-family: 'Roboto Flex', sans-serif;
}
p{
    margin: 0.5rem 0px;
}
    .workout{
        background-color: #131515;
        color:white;
        
    }
    .comp{
        position: relative;
        left:5vw;
        height:auto;
        width : 90vw;


    }
    .check{
        min-width:25px;
        min-height:25px !important;
        max-height: 25px;
        max-width: 25px;
    }
    .weekcheck{
        display: flex;
        width: 100%;
        justify-content: space-evenly;
        background-color: #212323;
        margin-top:10px;
        margin-bottom: 50px;
    }
    .daycheck{
        padding: 15px ;
    }
    .profile{
        height: 80%;
        background-color: #212323;
        width: 100%;
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        align-items: center;
    }
    .profileimg{
        width: 12vw !important;
        max-height: 12vw !important;
        min-height: 12vw !important;
        object-fit: cover;
        border-radius: 70%;
        margin-right: 40px;
    }
    .profile_1{
        width: 100%;
        display: flex;
        justify-content: space-around;
        align-items: center;
    }
    .routineAddbtn{
    width:130px;
    background-color: #7DE2D1;
    padding: 3px 5px;
    font-weight: bold;
    border-color: #7DE2D1;
    }
    .custom-control{
        font-size: 20px;
        margin: 3px;
        
    }
</style>