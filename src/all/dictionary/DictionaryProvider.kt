package dictionary

import all.dictionary.types.ListDictionary
import dictionary.types.HashSetDictionary
import dictionary.types.TreeSetDictionary

class DictionaryProvider {
    companion object {
        fun createDictionary(type: DictionaryType): IDictionary {
            return when (type) {
                DictionaryType.ARRAY_LIST -> ListDictionary
                DictionaryType.TREE_SET -> TreeSetDictionary
                DictionaryType.HASH_SET -> HashSetDictionary
            }
        }
    }
}