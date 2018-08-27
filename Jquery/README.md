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
