/*
 * Copyright (c) 2019.  Cristian Merino, All rights reserved.
 * https://linkedin.com/chrismerino
 */

package sv.edu.bitlab.desafio.cristian.DataModel

data class Account (var accountName: String? = null,
                    var accountEmail: String? = null,
                    var accountPhone: String? = null,
                    var accountFoundOutBy: String? = null,
                    var accountImage: String? = null)