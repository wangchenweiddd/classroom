import * as types from './mutation-types'

const mutations = {
  [types.SET_CURRENTNAV] (state, currentNav) {
    state.currentNav = currentNav
  },

  [types.SET_ADMIN_CURRENTNAV] (state, adminCurrentNav) {
    state.adminCurrentNav = adminCurrentNav
  }
}

export default mutations
