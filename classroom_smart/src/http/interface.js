import axios from './api'


// //获取用户的姓名和部门
// export const getUserInfo = (userJobNumber, userIdNumber) => {
//   return axios({
//     url: '/vmware/user/register/get/message',
//     params: {
//       userJobNumber,
//       userIdNumber
//     }
//   })
// }
//
// //用户注册
// export const userRegister = jsonData => {
//   return axios({
//     url: '/vmware/user/register',
//     data: jsonData,
//     method: 'post'
//   })
// }
export const userLogin = (json) => {
  return axios({
    url: '/class/manage/user/login',
    method: 'post',
    data: json
  })
}

export const getTree = userId => {
  return axios({
    url:'/class/manage/monitor/tree',
    // url: 'https://wechat.ahu.edu.cn/wechat/manage/monitor/tree',
    params: {
      userId
    }
  })
}

export const getPduTree = (json) => {
  return axios({
    url: '/class/operation/show/tree',
    method: 'post',
    data: json
  })
}

export const getPduList = (json) => {
  return axios({
    url: '/class/operation/show/list',
    method: 'post',
    data: json
  })
}

export const getPduStatus = (json) => {
  return axios({
    url: '/class/operation/show/line/status',
    method: 'post',
    data: json
  })
}

export const getPduSwitch = (json) => {
  return axios({
    url: '/class/operation/show/single/switch',
    method: 'post',
    data: json
  })
}

export const getPduDetail = (json) => {
  return axios({
    url: '/class/operation/show/detail/info',
    method: 'post',
    data: json
  })
}

export const getdianliu = (json) => {
  return axios({
    url: '/class/operation/show/detail/info/chart/current',
    method: 'post',
    data: json
  })
}

export const getdianya = (json) => {
  return axios({
    url: '/class/operation/show/detail/info/chart/voltage',
    method: 'post',
    data: json
  })
}

export const getClassroomData = (userId, regionCode) => {
  return axios({
    url: '/class/class/status',
    params: {
      userId,
      regionCode
    }
  })
}

export const getAirConditionData = (userId, regionCode, select) => {
  return axios({
    url:'/class/manage/monitor/status',
    // url: 'https://wechat.ahu.edu.cn/wechat/manage/monitor/status',
    params: {
      userId,
      regionCode,
      select
    }
  })
}

export const getAirConditionCount = (userId, regionCode) => {
  return axios({
    url:'/class/manage/monitor/status/count',
    params: {
      userId,
      regionCode,
    }
  })
}

export const getDailyData = (userId, startTime, endTime) => {
  return axios({
    url:'/class/logger/control/all/list',
    params: {
      userId,
      startTime,
      endTime
    }
  })
}

export const getDailyDetail = (operateId, status) => {
  return axios({
    url:'/class/logger//control/detail/list',
    params: {
      operateId,
      status
    }
  })
}

export const getAnalysis = () => {
  return axios({
    url:'/class/statistics/show',
    params: {
    }
  })
}

export const airControl = data => {
  return axios({
    method: 'post',
    url: '/class/manage/monitor/control',
    data
  })
}

// 172.19.15.135:8088/class/class/status
//https://wechat.ahu.edu.cn/wechat/manage/monitor/status?userId=221&regionCode=0&select=%E6%80%BB%E6%95%B0


export default {
  userLogin,
  getPduList,
  getPduTree,
  getPduStatus,
  getPduSwitch,
  getPduDetail,
  getdianliu,
  getdianya,
  getAirConditionData,
  getClassroomData,
  getTree,
  getDailyData,
  getDailyDetail,
  getAirConditionCount,
  getAnalysis,
  airControl
  // getUserInfo,
  // userRegister
}
