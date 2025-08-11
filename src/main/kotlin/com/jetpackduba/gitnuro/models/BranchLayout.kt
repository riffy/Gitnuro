package com.jetpackduba.gitnuro.models

import com.jetpackduba.gitnuro.ui.dropdowns.DropDownOption

data class BranchLayout (
    val useFolderDisplay: Boolean = true, // If set to true, branches will be displayed as folders
    val branchType: BranchType = BranchType.BOTH, // Which branch type is affected by this setting
    val nestingLevel: Int = 2, // How many nests / folders should be displayed, before squash applies
    val nestDelimiter: String = "/", // Which string should be used to apply the delimiter for identify nesting
)

enum class BranchType(val displayName: String) {
    LOCAL("Local"),
    REMOTE("Remote"),
    BOTH("Both");

    fun includesRemote() = this == BOTH || this == REMOTE;
    fun includesLocal() = this == BOTH || this == LOCAL;
}

val branchTypeLists = listOf(
    DropDownOption(BranchType.LOCAL, BranchType.LOCAL.displayName),
    DropDownOption(BranchType.REMOTE, BranchType.REMOTE.displayName),
    DropDownOption(BranchType.BOTH, BranchType.BOTH.displayName),
)