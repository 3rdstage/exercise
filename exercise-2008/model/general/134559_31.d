format 76

classcanvas 128031 class_ref 141599 // System
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 344 130 2000
end
classcanvas 128159 class_ref 141727 // Server
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 349 289 2000
end
classcanvas 128287 class_ref 141855 // Package
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 538 293 2000
end
classcanvas 128415 class_ref 141983 // Component
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 530 419 2000
end
classcanvas 128543 class_ref 142111 // Module
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 749 419 2000
end
classcanvas 128671 class_ref 142239 // Service
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 88 131 2000
end
relationcanvas 128799 relation_ref 134943 // has
  from ref 128031 z 2001 label "has" italic xyz 364 218 2001 stereotype "<<set>>" xyz 353 231 3000 to ref 128159
  role_a_pos 387 271 3000 role_b_pos 386 182 3000
  multiplicity_a_pos 345 271 3000 multiplicity_b_pos 359 182 3000
end
relationcanvas 128927 relation_ref 135071 // <association>
  from ref 128159 z 2001 to ref 128287
  no_role_a no_role_b
  multiplicity_a_pos 505 317 3000 multiplicity_b_pos 417 317 3000
end
relationcanvas 129055 relation_ref 135199 // <directional aggregation>
  from ref 128287 z 2001 to ref 128415
  no_role_a no_role_b
  multiplicity_a_pos 543 401 3000 multiplicity_b_pos 543 335 3000
end
relationcanvas 129183 relation_ref 135327 // implemented by
  from ref 128415 z 2001 label "implemented by" italic xyz 636 424 2001 to ref 128543
  no_role_a no_role_b
  multiplicity_a_pos 716 443 3000 multiplicity_b_pos 632 443 3000
end
relationcanvas 129311 relation_ref 135455 // provided by
  from ref 128671 z 2001 label "provided by" italic xyz 212 140 2001 to ref 128031
  role_a_pos 282 136 3000 no_role_b
  multiplicity_a_pos 326 159 3000 multiplicity_b_pos 164 159 3000
end
end
