2018.08.27 Jquery Selector
<h2>Basic </h2>
<ul>
  <li>All Selector (“*”)</li>
  <li>Class Selector (“.class”)</li>
  <li>Element Selector (“element”)</li>
  <li>ID Selector (“#id”)</li>
  <li>Multiple Selector (“selector1, selector2, selectorN”)</li>
</ul>

<h2>Basic Filter</h2>
<ul>
  <li>:animated Selector</li>
  Select all elements that are in the progress of an animation at the time the selector is run.
  <li>:eq Selector</li>
  Select the element at index n within the matched set.
  <li>:even Selector</li>
  Selects even elements, zero-indexed. See also odd.
  <li>:first Selector</li>
  Selects the first matched DOM element.
  <li>:focus Selector</li>
  Selects element if it is currently focused.
  <li>:gt() Selector</li>
  Select all elements at an index greater than index within the matched set.
  <li>:header Selector</li>
  Selects all elements that are headers, like h1, h2, h3 and so on.
  <li>:lang() Selector</li>
  Selects all elements of the specified language.
  <li>:last Selector</li>
  Selects the last matched element.
  <li>:lt() Selector</li>
  Select all elements at an index less than index within the matched set.
  <li>:not() Selector</li>
  Selects all elements that do not match the given selector.
  ex) $( "input:not(:checked) + span" ).css( "background-color", "yellow" );
  <li>:odd Selector</li>
  Selects odd elements, zero-indexed. See also even.
  <li>:root Selector</li>
  Selects the element that is the root of the document.
  <li>:target Selector</li>
  Selects the target element indicated by the fragment identifier of the document’s URI.
</ul>
<h2>Attribute</h2>
<ul>
  <li>Attribute Contains Prefix Selector [name|=”value”]</li>
  Selects elements that have the specified attribute with a value either equal to a given string or starting with that string followed by a hyphen (-).
  <li>Attribute Contains Selector [name*=”value”]</li>
  Selects elements that have the specified attribute with a value containing a given substring.
  <li>Attribute Contains Word Selector [name~=”value”]</li>
  Selects elements that have the specified attribute with a value containing a given word, delimited by spaces.
  <li>Attribute Ends With Selector [name$=”value”]</li>
  Selects elements that have the specified attribute with a value ending exactly with a given string. The comparison is case sensitive.
  <li>Attribute Equals Selector [name=”value”]</li>
  Selects elements that have the specified attribute with a value exactly equal to a certain value.
  <li>Attribute Not Equal Selector [name!=”value”]</li>
  Select elements that either don’t have the specified attribute, or do have the specified attribute but not with a certain value.
  <li>Attribute Starts With Selector [name^=”value”]</li>
  Selects elements that have the specified attribute with a value beginning exactly with a given string.
  <li>Has Attribute Selector [name]</li>
  Selects elements that have the specified attribute, with any value.
  <li>Multiple Attribute Selector [name=”value”][name2=”value2″]</li>
  Matches elements that match all of the specified attribute filters.
</ul>
<h2>Child Filter</h2>
<ul>
  <li>:first-child Selector</li>
  Selects all elements that are the first child of their parent
  <li>:first-of-type Selector</li>
  Selects all elements that are the first among siblings of the same element name.
  <li>:last-child Selector</li>
  Selects all elements that are the last child of their parent.
  <li>:last-of-type Selector</li>
  Selects all elements that are the last among siblings of the same element name.
  <li>:nth-child() Selector</li>
  Selects all elements that are the nth-child of their parent.
  <li>:nth-last-child() Selector</li>
  Selects all elements that are the nth-child of their parent, counting from the last element to the first.
  <li>:nth-last-of-type() Selector</li>
  Selects all the elements that are the nth-child of their parent in relation to siblings with the same element name, counting from the last element to the first.
  <li>:nth-of-type() Selector</li>
  Selects all elements that are the nth child of their parent in relation to siblings with the same element name.
  <li>:only-child Selector</li>
  Selects all elements that are the only child of their parent.
  <li>:only-of-type Selector</li>
  Selects all elements that have no siblings with the same element name.
</ul>
