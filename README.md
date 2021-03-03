# **Shared Element Transition with Recycler View**

![imgTransition](https://media.giphy.com/media/Oehu3jpjArEGlmZ4rr/giphy.gif)

**Step 1 : set unique transition name to shared element** 

app/src/main/java/com/example/imgtransitionwithrecyclerview/ItemsAdapter.kt (line 51)

In adapter each list element should have unique transitionName like this:

```
binding.img.transitionName = "img_item_unique_name_${item.id}"
```

**Step 2 : set shared element communication between Fragment with items list and destination Fragment** 

app/src/main/java/com/example/imgtransitionwithrecyclerview/ItemsFragment.kt (from line 42 do 50)

Now You need to find in Your Fragment with items list target element by transition name, where shered img should transition and tell it to FragmentNavigatorExtras and simple navigate to destination Fragment with "extras".

```
override fun onItemClicked(imageView: ImageView, item: Item) {
    val detailImageTransitionName = getString(R.string.detail_img_transition_name)
    val extras = FragmentNavigatorExtras(imageView to detailImageTransitionName)
    val navAction = ItemsFragmentDirections.actionItemsFragmentToItemDetailsFragment(item.id)
    imageView.findNavController().navigate(navAction, extras)
}
```

**Step 3 : pick up transition element in destination Fragment** 

app/src/main/java/com/example/imgtransitionwithrecyclerview/ItemDetailsFragment.kt (from line 33)

On "onCreate" set sharedElementTransition and transition properties as You like

```
enterTransition = MaterialFadeThrough().setDuration(400.toLong())

sharedElementEnterTransition = MaterialContainerTransform().apply {
        duration = 400.toLong()
        scrimColor = Color.TRANSPARENT
        setAllContainerColors(requireContext().themeColor(R.attr.colorSurface))
        drawingViewId = R.id.nav_host_fragment
    }
}
